package edu.jhu.cvrg.dbapi.dto;

public class FileInfoDTO {

	private Long documentRecordId;
	private Long fileEntryId;
	private Long analysisJobId;
	
	public FileInfoDTO(Long documentRecordId, Long fileEntryId) {
		super();
		this.documentRecordId = documentRecordId;
		this.fileEntryId = fileEntryId;
	}
	
	public FileInfoDTO(Long documentRecordId, Long fileEntryId, Long analysisJobId) {
		super();
		this.documentRecordId = documentRecordId;
		this.fileEntryId = fileEntryId;
		this.analysisJobId = analysisJobId;
	}
	
	public Long getDocumentRecordId() {
		return documentRecordId;
	}
	public void setDocumentRecordId(Long documentRecordId) {
		this.documentRecordId = documentRecordId;
	}
	public Long getFileEntryId() {
		return fileEntryId;
	}
	public void setFileEntryId(Long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
	public Long getAnalysisJobId() {
		return analysisJobId;
	}
	public void setAnalysisJobId(Long analysisJobId) {
		this.analysisJobId = analysisJobId;
	}
	
}
