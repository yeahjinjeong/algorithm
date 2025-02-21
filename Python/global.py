direction = 5
direction2 = 3
global direction3
direction3 = 1

def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3
    direction2 = 2
    # direction3 += 1 # UnboundLocalError: cannot access local variable 'direction3' where it is not associated with a value
    # SyntaxError: name 'direction3' is assigned to before global declaration
    global direction3
    direction3 += 1

turn_left()

direction3 += 1

turn_left()

print(direction) # 3
print(direction2) # 3
print(direction3) # 4