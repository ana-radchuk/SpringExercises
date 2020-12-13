package ua.lviv.lgs.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.domain.FileMultipart;
import ua.lviv.lgs.dao.FileMultipartRepo;

@Service
public class FileMultipartService {

	@Autowired
	private FileMultipartRepo fileMultipartRepo;

	public FileMultipart storeFile(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileMultipart multipart = null;

		if (!fileName.contains("..")) {
			multipart = new FileMultipart(fileName, file.getContentType(), file.getBytes());
		}

		return fileMultipartRepo.save(multipart);
	}

	public FileMultipart getFile(String fileId) throws FileNotFoundException {
		return fileMultipartRepo.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("File not found with Id =" + fileId));
	}
}
