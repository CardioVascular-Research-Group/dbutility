package edu.jhu.cvrg.dbapi.dto;

import java.io.Serializable;

public class FileTypes implements Serializable{

	private static final long serialVersionUID = 1L;
	public int id;
	public String sName; // name of the file type
	public String sExtension;
	public String sDisplayShortName; // Human friendly name to be used by the UI when listing services.
	public String sToolTipDescription; // Short summary description (under 150 characters) suitable for displaying is a tooltip.
	public String sLongDescription; // Complete description suitable for using in a manual/help file.
}
