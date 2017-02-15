package services.post;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import db.db_Like_Helper;
import db.db_Post_Helper;
import services.utils.Service;
import util.Dico;
import util.Error;
import util.LucasException;
import util.Parameters;
import util.TestError;

public class SAddLike extends Service {

	public SAddLike() throws NumberFormatException, ClassNotFoundException,
			IOException, SQLException, JSONException, LucasException {
		// TODO Auto-generated constructor stub
	}

	public SAddLike(Parameters params) throws NumberFormatException,
			ClassNotFoundException, IOException, SQLException, JSONException,
			LucasException {
		super(params);
		// TODO Auto-generated constructor stub
	}
	public SAddLike(Parameters params, HttpServletResponse resp)
			throws NumberFormatException, ClassNotFoundException, IOException,
			SQLException, JSONException, LucasException {
		super(params, resp);
		// TODO Auto-generated constructor stub
	}

	public SAddLike(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, ClassNotFoundException, IOException,
			SQLException, JSONException, LucasException {
		super(req, resp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] giveGetEntry() {
		// TODO Auto-generated method stub
		return Dico.vs_a("key","id_post");
	}

	@Override
	public Parameters to_json() {
		// TODO Auto-generated method stub
		return Dico.vT_toP(this, "response");
	}

	@Override
	public void koko() {
		// TODO Auto-generated method stub
		try {
			if (TestError.params_auth(this)) {
				if (!db_Post_Helper.c().CheckIfExistWith(params.PS("id_post").change("id_post", "id"))) {
					RespS.c(this, Error.MongoError.detail("id _post inconnu"));
					return;
				}
				if (!db_Like_Helper.c().InsertLike(params)) {
					RespS.c(this, Error.MongoError.detail("inser likes"));
					return;
				}
				Local_params.AddParam("response",params.getDico("id"));
				RespS.cj(this);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
