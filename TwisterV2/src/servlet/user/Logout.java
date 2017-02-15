package servlet.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import services.user.SLogout;
import util.LucasException;

/**
 * Classe représentant un servlet de déconnexion
 */
@SuppressWarnings("serial")
public class Logout extends HttpServlet {
	
	/**
	 * Appellera le service nécessaire à l'exécution de notre requête
	 * @param req Requête à exécuter
	 * @param resp Réponse de la requête
	 */

protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

	try {
		new SLogout(req, resp).print();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (LucasException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
