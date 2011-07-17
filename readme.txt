Overview

	These modules are samples for "Practical RichFaces" 2nd edition by Max Katz and Ilya Shaikovsky.

	All the samples uses RichFaces 4.0.1 Snapshots in order to include most important fixes which were made
	according to community reports after first final release. Some samples will not work properly without those 
	fixes so please consider using 4.0.1 or 4.1.0 if will try to play with the samples code in your own projects.

Running samples

	1) Execute mvn install in root folder of any sample.
	2) publish to tomcat 6 or 7 (default build creates tomcat targetted war)
	3) Open in favorite browser to check the result

Import to Eclipse:
	
	There are two options of import:
	
	1) Using m2eclipse plugin and importing as maven project

	2) Without maven plugins. Executing mvn eclipse:eclipse -Dwtpversion=2.0 to generate all needed metadata 
	   and importing as existent project.