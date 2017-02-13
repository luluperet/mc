package services.friend;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import db.db_Friend_Helper;
import db.db_User_Helper;
import services.utils.Service;
import util.Dico;
import util.Error;
import util.JSONHelper;
import util.LucasException;
import util.Parameters;
import util.io;

public class SListFriends extends Service {

	public SListFriends() throws NumberFormatException, ClassNotFoundException, IOException, SQLException,
			JSONException, LucasException {
		// TODO Auto-generated constructor stub
	}

	public SListFriends(Parameters params) throws NumberFormatException, ClassNotFoundException, IOException,
			SQLException, JSONException, LucasException {
		super(params);
		// TODO Auto-generated constructor stub
	}

	public SListFriends(Parameters params, HttpServletResponse resp) throws NumberFormatException,
			ClassNotFoundException, IOException, SQLException, JSONException, LucasException {
		super(params, resp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] giveGetEntry() {
		// TODO Auto-generated method stub
		return Dico.vs_a("key");
	}

	@Override
	public Parameters to_json() {
		// TODO Auto-generated method stub
		return Dico.vT_toP(this, "response");
	}

	@Override
	public void koko() {
		// TODO Auto-generated method stub
		if (params.CheckIfErrParams(getEntry)) {
			RespS.c(this, Error.ErrArgs);
			return;
		}
		try {
			if (!db_User_Helper.Auth(params)) {
				RespS.c(this, Error.NAUTH);
				return;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			RespS.c(this, Error.ClassNotFoundException);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			RespS.c(this, Error.SQLException);
		}
		try {
			Local_params.AddParam("response",db_Friend_Helper.listFriendsFromKey(params));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			RespS.c(this, Error.ClassNotFoundException);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			RespS.c(this, Error.SQLException);
		} catch (LucasException e) {
			// TODO Auto-generated catch block
			RespS.c(this, Error.LucasException);
		}
		try {
			io.print_json_or_print(response, JSONHelper.to_json(this));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			RespS.c(this, Error.IOException);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			RespS.c(this, Error.JSONException);
		}
	}

}