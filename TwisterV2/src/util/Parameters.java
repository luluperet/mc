package util;

import java.util.Arrays;  
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Parameters {
	public List<Dico> parameters;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Dico getDico(String key) {
		for (Dico dico : parameters) {
			if (dico.key.equals(key)) {
				return dico;
			}
		}
		return null;
	}
	public Parameters getDicos(String key) {
		Parameters p = new Parameters();
		for (Dico dico : parameters) {
			if (dico.key.equals(key)) {
				p.AddParam(dico);
			}
		}
		return p;
	}
	public List<String> getOnlyValues() {
		List<String> liste = new ArrayList<String>();
		for (Dico dico : parameters) {
			if (!dico.is_Dico()) {
				liste.add(dico.value);
			}
		}
		return liste;
	}
	public List<String> getOnlyKeys() {
		List<String> liste = new ArrayList<String>();
		for (Dico dico : parameters) {
			liste.add(dico.getKey());
		}
		return liste;
	}
	public String getValue(String key) {
			return getDico(key).getValue();
	}
	public int getValueInt(String key) {
		return Integer.parseInt(getDico(key).getValue());
}
	public List<String> getValuesk(String key) {
		return getDicos(key).getOnlyValues();
	}
	public List<String> getValues(String key) {
		return getDico(key).getValues();
}
	
	public Parameters(HttpServletRequest req) {
		parameters = new ArrayList<Dico>();
		Enumeration<String> parameterNames = req.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			Dico d = new Dico();
			String paramName = parameterNames.nextElement();
			d.setKey(paramName);
			String[] paramValues = req.getParameterValues(paramName);
			if (paramValues.length > 1) {
				d.setValues(paramValues);
				this.parameters.add(d);

			}else{
				
				if (paramValues[0].length() > 0) {
					
				d.value=paramValues[0];
				this.parameters.add(d);

				}
			}
		}
	
	}
	public static Parameters req(HttpServletRequest req) {
		return new Parameters(req);
	}
	public Parameters() {
		this.parameters = new ArrayList<Dico>();
				}
	public Parameters(List<Dico> l_dico) {
		this.parameters = l_dico;
	}
	public Parameters(Dico... values){
		this.parameters = new ArrayList<Dico>();
		for (int i = 0; i < values.length; i++) {
			this.AddParam(values[i]);
		}
	}
	public static Parameters fromDicos(Dico... values) {
		return new Parameters(values);
	}
	public Parameters AddParam(Dico dico){
		if (dico.getValue().length() > 0) {
		this.parameters.add(dico);
		}
		return this;
	}
	public boolean CheckIfErrParams(String[] params) {
		List<String> l = Arrays.asList(params);
		ArrayList<String> al = new ArrayList<String>(l);
		
		for (Dico dico : this.parameters) {
			if (al.contains(dico.key)) {
				al.remove(al.indexOf(dico.key));
			}
		}
		if (al.size() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String d = "";
		for (Dico dico : parameters) {
			d += dico.toString();
		}
		return d;
	}
	public static Parameters fromDico(List<Dico> d) {
		return new Parameters(d);
	}
	public static Parameters fromDicoPS(Parameters p,String...strings) {
		return fromDico(Dico.ps(p, strings));
	}
	public Parameters PS(String...strings) {
		return fromDico(Dico.ps(this, strings));
	}
}