package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@Service //bu sınıf business nesnesidir.
public class LanguageManager implements LanguageService{
	
	private LanguageRepository languageRepository;
	
	// Fonksiyonlarda iş kuralları belirt.
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	
	@Override
	public void add(Language language) throws Exception {
		List<Language> languages;
		languages = languageRepository.getAll();
		for(Language x : languages) {
			if(x.getName().equalsIgnoreCase(language.getName())) {
				throw new Exception("İsim kısmını boş geçemezsiniz.");
			}
		}
			if(language.getName().isBlank()){
				throw new Exception("Aynı isimle ekleme yapamazsınız.");
			}
			languageRepository.add(language);
		}
	
	
	@Override
	public void delete(int id) throws Exception{
		if(isIdExist(id)) {
			languageRepository.delete(id);
		}
	}
		
	@Override
	public void update(Language language) throws Exception{
		List<Language> languages = languageRepository.getAll();
		for(Language language1 : languages) {
			if(language1.getName().equalsIgnoreCase(language.getName())) {
				throw new Exception("Aynı isimle güncellenemez.");
			}
		}
		if(language.getName().isBlank()) {
			throw new Exception("Boş güncelleme yapılamaz.");
		}
		languageRepository.update(language);
		}
	
	@Override
	public Language getById(int id) throws Exception{
		return languageRepository.getById(id);
	}
	
	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}
	
	public boolean isIdExist(int id) throws Exception{
		for(Language language : getAll()) {
			if(language.getId() == id) {
				return true;
			}
		}
		throw new Exception("ID yok");
	}
	
	
}
