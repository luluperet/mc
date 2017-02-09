package services.friend;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import db.db_User_Helper;
import services.utils.Service;
import util.Dico;
import util.Error;
import util.LucasException;
import util.Parameters;
import util.io;

public class SSearch extends Service {

	public SSearch() throws NumberFormatException, ClassNotFoundException, IOException, SQLException, JSONException,
			LucasException {
		super();
	}

	public SSearch(Parameters params) throws NumberFormatException, ClassNotFoundException, IOException, SQLException,
			JSONException, LucasException {
		super(params);
	}

	public SSearch(Parameters params, HttpServletResponse resp) throws NumberFormatException, ClassNotFoundException,
			IOException, SQLException, JSONException, LucasException {
		super(params, resp);
	}

	@Override
	public String[] giveGetEntry() {
		return Dico.vs_a("key","query","friends");
	}

	@Override
	public Parameters to_json() {
		return null;
	}

	@Override
	public void koko() throws IOException, NumberFormatException, SQLException, JSONException, ClassNotFoundException,
			LucasException {
		if(params.CheckIfErrParams(getEntry)){
			io.print_json_or_print(response, Error.ErrArgs.depuis(this).to_JSON());
		}else{
			if (!db_User_Helper.Auth(params)) {
				io.print_json_or_print(response, Error.NAUTH.detail("key incorrect",this));
				return;
			}
		}
	}

}
