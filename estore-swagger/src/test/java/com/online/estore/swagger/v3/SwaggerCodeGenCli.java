package com.online.estore.swagger.v3;


import io.swagger.codegen.SwaggerCodegen;

public class SwaggerCodeGenCli {

    public static void main(String[] args) {
        String[] arguments = {
                "generate",
                "-i", "/Users/hchowdhary/Documents/GitProjects/estore/estore-swagger/src/test/resources/codegen/acs-api.yaml",
                "-o", "/Users/hchowdhary/Documents/GitProjects/estore/estore-swagger/target/codegen-cli",
                "-l", "spring",
                "-Dmodels",
                "-c", "/Users/hchowdhary/Documents/GitProjects/estore/estore-swagger/src/test/resources/codegen/config.json"
        };
        SwaggerCodegen.main(arguments);

    }
}
