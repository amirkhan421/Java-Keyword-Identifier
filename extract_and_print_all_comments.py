import re

st = """// This is a sample input file
x = 10  // Assign value
y = 20  // Another assignment

/*
This is a multi-line comment.
It spans several lines.
*/

z = x + y  // Add values
print(z)  // Output result
"""

# Extract single-line comments
single_line_comments = re.findall(r"//.*", st)

# Extract multi-line comments
multi_line_comments = re.findall(r"/\*[\s\S]*?\*/", st)

# Combine both types of comments
all_comments = single_line_comments + multi_line_comments

# Print extracted comments
for comment in all_comments:
    print(comment)
