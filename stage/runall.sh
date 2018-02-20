find ./tests/ -name "*.ul" > source.txt
filename="source.txt"
while read -r line
do
    	name="$line"
	echo Running on file $name
	cat $name
	java Compiler $name
done < "$filename"
