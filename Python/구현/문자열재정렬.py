S = input()

alphabet = []
sum = 0
for s in S:
    if ord(s) >= ord('A'):
        alphabet.append(s)
    else:
        sum += int(s)

print(alphabet)
print(sum)

alphabet.sort()
print("".join(alphabet) + str(sum))

# K1KA5CB7
# AJKDLSI412K4JSJ9D