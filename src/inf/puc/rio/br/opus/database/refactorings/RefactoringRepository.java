package inf.puc.rio.br.opus.database.refactorings;

import java.util.List;

import inf.puc.rio.br.opus.database.Repository;
import inf.puc.rio.br.opus.model.refactoring.Refactoring;


public class RefactoringRepository extends Repository {
	
	
	//https://www.mongodb.com/blog/post/getting-started-with-mongodb-and-java-part-i
	// https://www.baeldung.com/java-mongodb
	//https://mongodb.github.io/mongo-java-driver/3.5/driver/getting-started/quick-start-pojo/

	public RefactoringRepository(String[] args){
		init(args);
	}
	public void insertAllRefactorings(List<Refactoring> refList) {
		refactorings().insertMany(refList);
	}

}