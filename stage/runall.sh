find ./tests/complicated/ -name "*.ul" > source.txt
#find ./tests/complicated/ -cmin -1000 > source.txt 
filename="source.txt"
while read -r line
do
	printf "\n"
    	name="$line"
	echo Running on file $name
	cat -n  $name
	java Compiler $name
done < "$filename"
