package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
@Repository //bu sınıf data access nesnesidir.
public class inMemoryLanguageRepository implements LanguageRepository{
	
	List<Language> languages;
	
	public inMemoryLanguageRepository() {
		
		languages = new ArrayList<Language>();
		languages.add(new Language(1,"Java"));
		languages.add(new Language(2,"C#"));
		languages.add(new Language(3,"Python"));
		languages.add(new Language(4,"JavaScript"));
	
	}

	@Override
	public void add(Language language) {
		languages.add(language);
	}
	
	@Override
	public void delete(int id) throws Exception {
		languages.remove(getById(id));
		}
	
	@Override
	public void update(Language language) {
		languages.set((language.getId()-1), language);
	}
	
	@Override
	public Language getById(int id) throws Exception {
		for(Language language : getAll()) {
			if(language.getId() == id) {
				return language;
			}
		}
		throw new Exception("kayit bulunamadi");
	}
	
	@Override
	public List<Language> getAll() {
		return languages;
	}
}
