package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
public interface LanguageRepository {
	
	void add(Language language);
	void delete(int id) throws Exception;
	void update(Language language);
	Language getById(int id) throws Exception;
	List<Language> getAll();
	
}
