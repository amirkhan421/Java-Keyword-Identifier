import keyword
import re

# Sample input code as a string
code = """
def add(x, y):
    return x + y

if add(5, 3) > 5:
    print("Result is greater than 5")
else:
    print("Result is 5 or less")
"""

# Split code into words (identifiers and keywords)
words = re.findall(r'\b\w+\b', code)

# Identify keywords
keywords_found = [word for word in words if word in keyword.kwlist]

# Print detected keywords
print("Keywords in the code:", set(keywords_found))
