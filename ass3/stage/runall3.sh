

#find ./tests/withoutSubtypes/withoutSubtypes -name "*.ul" | sort -n > source.txt

#find ./moremoretests/reject/ -name "*.ul" > source.txt
find ./tests/valid/given/ -name "*.ul"  > source.txt 
filename="source.txt"
while read -r line
do
	printf "\n"
    	name="$line"
	echo java Compiler file $name
	cat -n  $name
	java Compiler $name
done < "$filename"
