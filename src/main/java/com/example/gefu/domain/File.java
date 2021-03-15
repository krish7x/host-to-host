package com.example.gefu.domain;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FILE")
public class File implements Serializable {
	private static final long serialVersionUID = -2012622188767611040L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "FILE_NAME", nullable = false, length = 100)
	private String fileName;

	@Column(name = "VALID", nullable = false)
	private Character isValid;

	@Column(name = "GEFU_DONE")
	private String isGefuDone;

	@Column(name = "GEFU_FILE")
	private String gefuFile;

	@Where(clause = "VALID='Y'")
	@OneToMany(mappedBy = "file", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<FileFormat> fileFormats = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Character getIsValid() {
		return isValid;
	}

	public void setIsValid(Character isValid) {
		this.isValid = isValid;
	}

	public String getIsGefuDone() {
		return isGefuDone;
	}

	public void setIsGefuDone(String isGefuDone) {
		this.isGefuDone = isGefuDone;
	}

	public String getGefuFile() {
		return gefuFile;
	}

	public void setGefuFile(String gefuFile) {
		this.gefuFile = gefuFile;
	}

	public List<FileFormat> getFileFormats() {
		return fileFormats;
	}

	public void setFileFormats(List<FileFormat> fileFormats) {
		this.fileFormats = fileFormats;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", fileName=" + fileName + ", isValid=" + isValid + "]";
	}
	
	
}