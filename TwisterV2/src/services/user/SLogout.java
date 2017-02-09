/**
 * 
 */
package services.user;

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

/**
 * @author lucasiscovici
 *
 */
public class SLogout extends Service  {

	
	public SLogout() throws NumberFormatException, ClassNotFoundException, IOException, SQLException, JSONException,
			LucasException {
		super();
		// TODO Auto-generated constructor stub
	}

	public SLogout(Parameters params, HttpServletResponse resp) throws NumberFormatException, ClassNotFoundException,
			IOException, SQLException, JSONException, LucasException {
		super(params, resp);
		// TODO Auto-generated constructor stub
	}

	public SLogout(Parameters params) throws NumberFormatException, ClassNotFoundException, IOException, SQLException,
			JSONException, LucasException {
		super(params);
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
		return null;
	}

	@Override
	public void koko() throws IOException, NumberFormatException, SQLException, JSONException, ClassNotFoundException,
			LucasException {
		// TODO Auto-generated method stub
		if(params.CheckIfErrParams(getEntry)){
			io.print_json_or_print(response, Error.ErrArgs.to_JSON());
		}else{
			boolean ok_delete_session = db_User_Helper.DeleteSession(params);
			if (!ok_delete_session) {
				io.print_json_or_print(response, Error.SqlError.detail("Key Introuvable"));
			}else{
				io.print_text(response, "OK");
			}
		}
		
	}




	




}
