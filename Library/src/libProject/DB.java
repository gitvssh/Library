package libProject;

import java.util.ArrayList;
import java.util.List;

public abstract class DB {
	
	abstract List search(String title);
	
	abstract void input();
	
	abstract void delete(Data data);
	
	abstract void update(Data data);
	
	abstract List searchAll();
	
	abstract void align();

}
