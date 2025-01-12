package bgtransport.model;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Target;

/**
 * The GenerateCode class is responsible for generating Java code from a database schema using JOOQ.
 * It takes the database connection details and output paths as input and generates the necessary code for 
 * interacting with the database.
 */
public class GenerateCode {

    /**
     * Generates Java code from a database schema based on the given configuration parameters.
     * This includes connecting to the database, configuring the JOOQ code generation tool, 
     * and saving the generated code to the specified target directory.
     * 
     * @param db The JDBC URL for the database to connect to (e.g., SQLite or other supported databases).
     * @param jdbc The JDBC driver class name (e.g., "org.sqlite.JDBC").
     * @param sqLiteDatabase The name of the database for the JOOQ code generator configuration.
     * @param jooq The package name where the generated code will be placed.
     * @param src The directory where the generated source code will be stored.
     * @throws Exception If there is an error during the code generation process.
     */
    public static void generateCode(String db, String jdbc, String sqLiteDatabase, String jooq, String src)
            throws Exception {
        // Configure the JDBC connection for the database
        Jdbc jDbC = new Jdbc().withDriver(jdbc).withUrl(db);

        // Configure the database settings for JOOQ code generation
        Database database = new Database().withName(sqLiteDatabase).withIncludes(".*").withExcludes("");

        // Configure the target settings, such as the package name and source directory
        Target target = new Target().withPackageName(jooq).withDirectory(src);

        // Set up the JOOQ code generator
        Generator generator = new Generator().withDatabase(database).withTarget(target);

        // Configure the full code generation setup
        Configuration configuration = new Configuration().withJdbc(jDbC).withGenerator(generator);

        // Run the JOOQ code generation tool
        GenerationTool.generate(configuration);

        // Output a message indicating the code generation is complete
        System.out.println(src + " done!");
    }
}
