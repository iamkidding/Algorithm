import random

def insertion_sort(list):
    i = 1
    while i < len(list):
        key = list[i]
        j = i - 1
        while key < list[j] and j > -1:
            list[j + 1] = list[j]
            j -= 1
        list[j + 1] = key
        i += 1
    print(list)

def merge_sort(list):
    

# l = [2, 4, 768, 1, 34, 6, 8, 6]
test_list = []
for i in range(100):
    test_list.append(random.randint(0, 1000))
insertion_sort(test_list)
