package bgtransport.model;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Target;

public class GenerateCode {

	public static void generateCode(String db, String jdbc, String sqLiteDatabase, String jooq, String src)
			throws Exception {
		Jdbc jDbC = new Jdbc().withDriver(jdbc).withUrl(db);
		Database database = new Database().withName(sqLiteDatabase).withIncludes(".*").withExcludes("");
		Target target = new Target().withPackageName(jooq).withDirectory(src);
		Generator generator = new Generator().withDatabase(database).withTarget(target);
		Configuration configuration = new Configuration().withJdbc(jDbC).withGenerator(generator);
		GenerationTool.generate(configuration);
		System.out.println(src + " done!");
	}
}
