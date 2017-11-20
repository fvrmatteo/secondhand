import os
import re
import subprocess

def getEncodedStrings(lines):
	encoded = {}
	for line in lines:
		matches = re.findall(r"([a-zA-Z0-9]*)\((new char\[\]\{[^\[\]]*\})", line)
		if matches:
			for match in matches:
				funcname, params = match[0], match[1]
				params = params.split("}")[0] + "}"
				encoded.update({ funcname : params })
	return encoded

def getDecodeFunction(lines, funcname):
	pattern = "private static String " + funcname + "\(char\[\]"
	function = []
	for index, line in enumerate(lines):
		match = re.search(pattern, line)
		if match:
			function.append(line)
			index += 1
			while index < len(lines):
				function.append(lines[index])
				match = re.search(r"return new String", lines[index])
				if match:
					function.append(lines[index + 1])
					return function
				index += 1
	return function

def getDecodedStrings(lines):
	encoded = getEncodedStrings(lines)
	for funcname, params in encoded.items():
		decodeFunction = getDecodeFunction(lines, funcname)

		if not decodeFunction:
			print "[+] Failed to decode: " + funcname + ", " + params
			continue

		# Create the Java solver

		with open("Solver.java", "w") as solver:
			solver.write("class Solver {\n")
			for line in decodeFunction:
				solver.write(line)
			solver.write("\tpublic static void main(String[] args) {\n")
			solver.write("\t\tSystem.out.println(Solver." + funcname + "(" + params + "));\n")
			solver.write("\t}\n")
			solver.write("}\n")

		# Compile the file

		os.system("javac Solver.java")
		print funcname + " = " + subprocess.check_output("java Solver", shell=True)

		#raw_input()

if __name__ == "__main__":
	for root, dirs, files in os.walk("infiltration"):
		for name in files:
			if name.endswith(".java"):
				path = "./" + root + "/" + name
				with open(path, "r") as source:
					print "[+] Decoding strings in: " + path
					getDecodedStrings(source.readlines())
