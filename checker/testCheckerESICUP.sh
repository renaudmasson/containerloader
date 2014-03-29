#!/bin/bash

export CLASSPATH=./javaCheckerESICUP.jar

java -Xmx1024m javaCheckerESICUPPck.javaCheckerESICUPMain ./toy_instances_with_results 2>&1

ret=$?
if [ ${ret} -ne 0 ]
then
        exit 1
fi

exit 0
