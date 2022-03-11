#n → n/2 (n is even)
#n → 3n + 1 (n is odd)

collatzLen = {
    1: 1
}

def collatz(num):
    if num in collatzLen:
        return collatzLen[num]
    else:
        if (num % 2) == 0:
            #even
            x = (num / 2)
        else:
            #odd
            x = ((num * 3) + 1)
        
        print(x)
        collatzLen[x] = collatz(x) + 1
        return collatzLen[num]

print(collatz(100))