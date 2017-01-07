#!/bin/sh

# Sample deployment script for neo-api
# Use -t to deploy as test (http://www.example.com/test/)

appname=neo.war

source=target/$appname
target_dir=/var/lib/tomcat/webapps

if [ x$1 = x-t ]
then
    target=$target_dir/test.war
else
    target=$target_dir/$appname
fi

echo Deploying $target

mv $target $target.old

echo Waiting for tomcat to undeploy
while [ -d $target ] ; do sleep 1 ; done

cp $source $target
chmod 644 $target

source=
target_dir=
target=
