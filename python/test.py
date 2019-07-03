#!/usr/bin/python

print(2*4)
var = len("hello world")
print(f'Długość ciągu to {var}')

dictionary = {'key1':17, 'key2':8.01, 'key3':['test2', 55]}
print('element = {}'.format(dictionary['key3'][0]))

dictionary['key3'][0] = 1000
print('element = {}'.format(dictionary['key3'][0]))

tup = (1, 2, 3)
print('tuple element = {}'.format(tup[1]))
print('tuple size = {}'.format(tup.count(1)))

myset = set()

print(type(myset))

with open('myfile.txt', mode='w') as file:
    file.write('This is my file')
    file.close()

if True:
    print("it's true")
elif 1 > 2:
    print("Strange")
else:
    print("it's false")

su = 0
print('su type: {}'.format(type(su)))
for item in [1, 2, 3, 4]:
    if item % 2 == 0:
        su += 1
        print("{} {}".format(su, item))

print('------------')

for x, y in [(1,2), (5,2), (8,3)]:
    print(x, y)

print('------------')

dict = {
    'k1': 1,
    'k2': 2,
    'k3': 3
}

for k, v in dict:
    print (k, v)

print('dictionary types {} {}'.format(type(k), type(v)))
print('current v = ' + v)

print('--- while loop ----')
v = 0

while v < 3:
     print('yeah!')
     v += 1
else:
    pass
    print(f"I'm done. v = {v}")

pass

list2 = range(10, 100, 10)

print(list2)

print('------------')

for i,j in enumerate('abecadło'):
    print(i,j)

print('------------')
l1 = ['abc', 'def', 'ghi', 'rst', 'abc']
l2 = [10, 4.3, 'xyz', 46]
l3 = [True, False, False]

for m,n,o in zip(l1, l2, l3):
    print(m, n, o)

print('------------')

print('ok' in ['no', 'ok', 'tak', 'nie'])
print('k3' in {'k1': 'no', 'k2': 'ok','k3': 'tak','k4': 'nie'})

print(f'max = {max(list2)}')

from _random import Random
print(f'random = {shuffle(list2)}')
