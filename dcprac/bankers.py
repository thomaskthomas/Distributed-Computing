def bankers():
    p = int(input("Processes: "))
    r = int(input("Resources: "))

    print("Enter Allocation:")
    allocation = [[int(input()) for _ in range(r)] for _ in range(p)]

    print("Enter Max:")
    max_ = [[int(input()) for _ in range(r)] for _ in range(p)]

    print("Enter Available:")
    available = [int(input()) for _ in range(r)]

    need = [[max_[i][j] - allocation[i][j] for j in range(r)] for i in range(p)]

    finished = [False] * p
    safe_seq = []
    work = available[:]

    while len(safe_seq) < p:
        found = False

        for i in range(p):
            if not finished[i] and all(need[i][j] <= work[j] for j in range(r)):
                work = [work[j] + allocation[i][j] for j in range(r)]
                safe_seq.append(i)
                finished[i] = True
                found = True

        if not found:
            print("Not Safe")
            return

    print("Safe Sequence: " + " ".join(f"P{i}" for i in safe_seq))

bankers()