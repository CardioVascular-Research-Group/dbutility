package edu.jhu.cvrg.dbapi.dto;

public class ParameterValidator {
	private int id;
	private String type=""; // regex, in_range, length
	private String message=""; // The message displayed if validation fails.
	private float min; // 	a number, minimum parameter value; only valid when the parameter type is "integer" or "float"
	private float max;// 	a number, maximum parameter value; only valid when the parameter type is "integer" or "float"
	private String regex=""; // A javaScript regular expression which describes a valid entry for when the parameter type is "text". 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/** Can be of 3 types:<BR/>
			1 = regex - A javaScript regular expression which describes a valid entry for when type is "text".<BR/> 
			2 = in_range - Defines the minimum and maximum values that a numeric input (integer or float) can have.<BR/>
			3 = length -  Defines the minimum and maximum length that a text input can have.<BR/>
	 * @return - type string */
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	/** The message displayed if validation fails. 
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	/** a number, minimum parameter value; only valid when the parameter type is "integer" or "float"
	 * @return
	 */
	public float getMin() {
		return min;
	}
	public void setMin(float min) {
		this.min = min;
	}
	
	/** a number, maximum parameter value; only valid when the parameter type is "integer" or "float"
	 * 
	 * @return
	 */
	public float getMax() {
		return max;
	}
	public void setMax(float max) {
		this.max = max;
	}
	
	/** A javaScript regular expression which describes a valid entry for when the parameter type is "text".
	 * 
	 * @return
	 */
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
	}
}
