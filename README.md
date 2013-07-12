openshift-default-tomee-app
===========================

Demo war for [TomEE cartridge](https://github.com/AtosWorldline/openshift-cartridge-tomee)

## In short

    cd /path/to/the/git/app/repository
    cp /[...]/my-application.war webapps/ROOT.war
    git commit -a -m 'Some commit message' && git push
    reload this page!

## How can I use an OpenShift resource on my TomEE?

Use the web console or the CLI to add the required resource, let's say a database cartridge (MysqL, PostgreSQL, MongoDB). After
installation succeed, you will have to use the given environment variables instead of your usual login/password.

In order for TomEE to read credential information through environment variables you will have to use the syntax: *${VARIABLE}*
in your configuration file.

For instance, if you want to use a MySQL database using resources.xml (WEB-INF/classes/META-INF/resources.xml) you will write:

    JdbcDriver = com.mysql.jdbc.Driver
    UserName = ${OPENSHIFT_MYSQL_DB_USERNAME}
    Password = ${OPENSHIFT_MYSQL_DB_PASSWORD}
    JdbcUrl = jdbc:mysql://${OPENSHIFT_MYSQL_DB_HOST}:${OPENSHIFT_MYSQL_DB_PORT}/${OPENSHIFT_APP_NAME}
    [...]

You may use the same syntax in the tomee.xml file using openshift hooks scripts (.openshift/config/tomee.xml).
Using resources.xml should be prefered.

For a more detail example, you can checkout [JeBlog](https://github.com/rmannibucau/JeBlog).

## TomEE documentation

The TomEE website provide a really interesting documentation with a lot of source code and simple example.
Please visit the [TomEE website](http://tomee.apache.org) and especially [the example page](http://tomee.apache.org/examples-trunk/index.html)


