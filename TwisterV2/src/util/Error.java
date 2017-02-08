package util;

import org.json.JSONException;
import org.json.JSONObject;

public enum Error {
	  ErrArgs(-1, "Args Error"),
	  NAUTH(401, "Auth Error"),
	  SqlError(1000, "BD Error"),
	  JavaError(10000, "Java Error"),
	  JsonError(100, "pb JSON"),
	  //USER
		  //LOGIN
		  LoginExist(1,"User already exist with this login"),
		  LoginNotExist(1,"Unknow User"),
	  	  BadPassword(2,"Bad password");

	  private final int code;
	  private String description;
	  private String description2 = "";

	  Error(int code, String description) {
	    this.code = code;
	    this.description = description;
	  }

	  public String getDescription() {
	     return description;
	  }
	  public Error detail(String d) {
		this.description2 += " | Detail: "+d;
		  return this;
	}
	  public Error depuis(Object d) {
			  return this.depuis(d.getClass().getName());
		}
	  public Error depuis(String d) {
			this.description2 += " | Depuis: "+d;
			  return this;
		}
	  public Error detailT(Object t,String d) {
			  return this.detail(d).depuis(t);
		}
      
	  public int getCode() {
	     return code;
	  }
	  public Error setDescription(String d){
		  this.description = d;
		  return this;
	  }
	  @Override
	  public String toString() {
	    String dh = code + ": " + description + ": " + description2;
	    description2 = "";
	    return dh;
	  }
	 public static void main(String[] args) {
		  
		 //Error.DATABASE.setDescription("pb database").toJSON();
				  
	} 
	 public String to_JSON() throws JSONException {
		String d = new JSONObject().put("code", this.code).put("description", this.description+" "+this.description2).toString();
		 this.description2="";
		 return d;
	 }
	  
	}
