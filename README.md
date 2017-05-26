# Basic twitter POC

## Prerequisite:

To use LDAP

Please create users foo, bar, joe, mike, tom in ldap server and add corresponding LDAP maven dependency in pom.xml.  Apache DS pom.xml configuration is already added but commented out.

### Enable LDAP:
Uncomment the pox.xml LDAP dependency and rename  LDAPSecurityConfigurationAdaptor.java.orig to LDAPSecurityConfigurationAdaptor.java under security directory

## Steps:

 -Build the application by invoking mvn  package 
 -Run all tests by running UnitTestSuite classs
 -Run the application class to launch the application (Spring boot)

## REST URI

localhost:8080/users/foo - returns foo followees ( mike and bar) tweets
localhost:8080/users/foo/tweets - returns foo tweets 
localhost:8080/users/foo/followees - returns foo followees ( mike and bar)
localhost:8080/users/mike/followers - return mike followers ( foo and bar)


add followee to foo
localhost:8080/users/mike/followees 
{
  "followees": "joe"
}

check followers again
localhost:8080/users/joe/followers

access bar tweet
localhost:8080/users/bar/tweets/
post
{
  "content": "latest update"
}
Check newly added tweets
localhost:8080/users/bar/tweets/

