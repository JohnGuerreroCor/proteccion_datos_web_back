package com.usco.edu.dao.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IAutorizacionDatosPersonalesDao;
import com.usco.edu.entities.AutorizacionDatosPersonales;
import com.usco.edu.entities.AutorizacionModulo;
import com.usco.edu.rowMapper.AutorizacionModuloRowMapper;

@Repository
public class AutorizacionDatosPersonalesDaoImpl implements IAutorizacionDatosPersonalesDao {

	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplateConsulta;

	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public AutorizacionModulo obtenerAutorizacionPorEdad(Integer moduloCodigo, Integer perTerCodigo) {

		String sql = "DECLARE @codigo INT = ?; " + "DECLARE @modulo INT = ?; " + "DECLARE @estado_edad INT; "
				+ "SELECT TOP 1 " + "    @estado_edad = CASE " + "        WHEN fecha_nacimiento IS NULL THEN 0"
				+ "        WHEN DATEDIFF(YEAR, fecha_nacimiento, GETDATE()) - "
				+ "             CASE WHEN DATEADD(YEAR, DATEDIFF(YEAR, fecha_nacimiento, GETDATE()), fecha_nacimiento) > GETDATE() THEN 1 ELSE 0 END "
				+ "             >= 18 THEN 0 " + "        ELSE 1 " + "    END " + "FROM ( " + "    SELECT  "
				+ "        per_fecha_nacimiento AS fecha_nacimiento " + "    FROM Persona "
				+ "    WHERE per_codigo = @codigo " + "    UNION ALL " + "    SELECT  "
				+ "        ter_fecha_nacimiento AS fecha_nacimiento " + "    FROM Tercero "
				+ "    WHERE NOT EXISTS (SELECT 1 FROM Persona WHERE per_codigo = @codigo) "
				+ "      AND ter_codigo = @codigo " + ") AS datos; " + "SELECT  " + "    am.*, " + "    a.aut_titulo, "
				+ "    a.aut_anexo_requerido, " + "    a.aut_estado, " + "    m.*," + "    ss.*," + "    s.*,"
				+ "    @estado_edad AS estado_edad " + "FROM protecciondatos.autorizacion_modulo am "
				+ "INNER JOIN protecciondatos.autorizacion a  " + "    ON am.aut_codigo = a.aut_codigo "
				+ "INNER JOIN dbo.modulo m " + "    ON am.mod_codigo = m.mod_codigo " + "INNER JOIN dbo.sub_sistema ss "
				+ "    ON m.ssi_codigo = ss.ssi_codigo " + "INNER JOIN dbo.sistema s "
				+ "    ON ss.sis_codigo = s.sis_codigo " + "WHERE am.mod_codigo = @modulo "
				+ "  AND a.aut_anexo_requerido = @estado_edad;";

		try {

			return jdbcTemplateConsulta.queryForObject(sql, new Object[] { perTerCodigo, moduloCodigo },
					new AutorizacionModuloRowMapper());

		} catch (EmptyResultDataAccessException e) {

			return null;

		}

	}

	@Override
	public AutorizacionModulo obtenerAutorizacionMenorEdad(Integer moduloCodigo) {

		String sql = "select * from protecciondatos.autorizacion_modulo am "
				+ "inner join protecciondatos.autorizacion a on am.aut_codigo = a.aut_codigo "
				+ "inner join dbo.modulo m on am.mod_codigo = m.mod_codigo "
				+ "inner join dbo.sub_sistema ss on m.ssi_codigo = ss.ssi_codigo "
				+ "inner join dbo.sistema s on ss.sis_codigo = s.sis_codigo "
				+ "where am.aum_estado = 1 and a.aut_anexo_requerido = 1 and am.mod_codigo = ?;";

		try {

			return jdbcTemplateConsulta.queryForObject(sql, new Object[] { moduloCodigo },
					new AutorizacionModuloRowMapper());

		} catch (EmptyResultDataAccessException e) {

			return null;

		}

	}

	@Override
	public AutorizacionModulo obtenerAutorizacionMayorEdad(Integer moduloCodigo) {

		String sql = "select * from protecciondatos.autorizacion_modulo am "
				+ "inner join protecciondatos.autorizacion a on am.aut_codigo = a.aut_codigo "
				+ "inner join dbo.modulo m on am.mod_codigo = m.mod_codigo "
				+ "inner join dbo.sub_sistema ss on m.ssi_codigo = ss.ssi_codigo "
				+ "inner join dbo.sistema s on ss.sis_codigo = s.sis_codigo "
				+ "where am.aum_estado = 1 and a.aut_anexo_requerido = 0 and am.mod_codigo = ?;";

		try {

			return jdbcTemplateConsulta.queryForObject(sql, new Object[] { moduloCodigo },
					new AutorizacionModuloRowMapper());

		} catch (EmptyResultDataAccessException e) {

			return null;

		}

	}

	@Override
	public AutorizacionModulo obtenerAutorizacionPorTipoUsuario(Integer moduloCodigo, Integer usuarioTipoCodigo) {

		String sql = "select * from protecciondatos.autorizacion_modulo am "
				+ "inner join protecciondatos.autorizacion a on am.aut_codigo = a.aut_codigo "
				+ "inner join dbo.modulo m on am.mod_codigo = m.mod_codigo "
				+ "inner join dbo.sub_sistema ss on m.ssi_codigo = ss.ssi_codigo "
				+ "inner join dbo.sistema s on ss.sis_codigo = s.sis_codigo "
				+ "inner join protecciondatos.autorizacion_configuracion ac on am.aut_codigo = ac.aut_codigo "
				+ "where am.aum_estado = 1 and a.aut_anexo_requerido = 0 and am.mod_codigo = ? and ac.tus_codigo = ?;";

		try {

			return jdbcTemplateConsulta.queryForObject(sql, new Object[] { moduloCodigo, usuarioTipoCodigo },
					new AutorizacionModuloRowMapper());

		} catch (EmptyResultDataAccessException e) {

			return null;

		}

	}

	@Override
	public boolean validarAutorizacion(Integer autorizacionCodigo, Integer perTerCodigo) {
		String sql = "DECLARE @codigo INT = ?;" + "DECLARE @autorizacion INT = ?;" + "SELECT CASE WHEN EXISTS ("
				+ "SELECT 1 FROM dbo.autorizacion_terminos at "
				+ "WHERE (at.per_codigo = @codigo OR at.ter_codigo = @codigo)" + "AND at.aut_codigo = @autorizacion"
				+ ") THEN 1 ELSE 0 END AS autorizado;";

		Boolean autorizado = jdbcTemplateConsulta.queryForObject(sql, Boolean.class, perTerCodigo, autorizacionCodigo);

		return autorizado != null && autorizado;
	}

	@Override
	public int registrarAutorizacion(AutorizacionDatosPersonales autorizacionDatosPersonales) {

		String sql = "INSERT INTO dbo.autorizacion_terminos "
				+ "(per_codigo, ter_codigo, mod_codigo, aut_codigo, doc_codigo, uid, aute_session_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			int result = jdbcTemplateEjecucion.update(sql,
					new Object[] {
							autorizacionDatosPersonales.getPersonaCodigo() != null
									? autorizacionDatosPersonales.getPersonaCodigo()
									: null,
							autorizacionDatosPersonales.getTerceroCodigo() != null
									? autorizacionDatosPersonales.getTerceroCodigo()
									: null,
							autorizacionDatosPersonales.getModuloCodigo(),
							autorizacionDatosPersonales.getAutorizacionCodigo(),
							autorizacionDatosPersonales.getDocumentoCodigo(), autorizacionDatosPersonales.getUid(),
							autorizacionDatosPersonales.getSessionId() });

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
