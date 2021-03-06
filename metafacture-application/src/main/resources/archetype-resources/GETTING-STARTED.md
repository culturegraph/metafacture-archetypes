# Getting started

This is a template for a project which uses Metafacture. Most things
have already been configured for you but there are three TODOs in the
`pom.xml` which you need to complete yourself:
 
1. Add developer information
2. Add SCM information
3. Add issue tracker information

The `pom.xml` already contains the comments with the necessary mark up.
All you have to do is add the information and remove the comments.


## Changing the project license

The project is set-up with an Apache 2.0 license. If you want to use a
different license, you have to make some modifications to the project
set-up:

1. Update the license information in the `pom.xml`
2. Copy the license header which appears at the beginning of each file 
    into `quality_assurance/java-header.txt`
3. Modify the `ignoreLines` property of the Header module in 
    `quality_assurance/checkstyle_rules.xml` to exclude lines in your
    license header which may have varying content (such as names or
    dates)
4. Change the lines-attribute in
    `quality_assurance/checkstyle-suppressions.xml` to match the number
    of lines in `quality_assurance/java-header.txt`
5. Replace the Apache 2.0 `LICENSE` file with your new license