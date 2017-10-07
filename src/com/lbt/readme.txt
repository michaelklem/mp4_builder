this code was the original code for the mp4 service.

it will look thru the db and compile each story

this will need to be modified to find the next story to be compiled
based on the date initiated ordered by ascending and with no error



bin/
jar -cvfm ../mcutility_aws.jar ../resources/MANIFEST.MF .
scp ../mcutility_aws.jar lbtadmin@45.33.35.67:.


lbt01
mv mcutility_aws.jar /tmp


lbt01 root
mv /tmp/mcutility_aws.jar .

/usr/bin/java -cp "/root/mp4_builder/mcutility_aws.jar:external_jars/*" com.lbt.Program   property_file littlebirdtale_en_US_lbtprod.properties -Dfile.encoding=iso-8859-1

