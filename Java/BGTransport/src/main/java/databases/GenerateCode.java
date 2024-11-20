package databases;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Target;

// codice per generare i sorgenti a partire dal DB
public class GenerateCode {

	public static void generateCode(String db, String jdbc, String SQLiteDatabase, String jooq, String src)
			throws Exception {
		Jdbc JDBC = new Jdbc().withDriver(jdbc).withUrl(db);
		Database database = new Database().withName(SQLiteDatabase).withIncludes(".*").withExcludes("");
		Target target = new Target().withPackageName(jooq).withDirectory(src);
		Generator generator = new Generator().withDatabase(database).withTarget(target);
		// generator.getGenerate().setPojos(true);
		Configuration configuration = new Configuration().withJdbc(JDBC).withGenerator(generator);
		GenerationTool.generate(configuration);
		System.out.println(src + " done!");
	}
}
