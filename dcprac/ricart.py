def ricart():
    n = int(input("Enter number of processes: "))

    print("Enter timestamps:")
    ts = [int(input()) for _ in range(n)]

    p = int(input(f"Enter requesting process (0 to {n - 1}): "))

    replies = 0

    print(f"\nP{p} requests CS")

    for i in range(n):
        if i == p:
            continue

        print(f"P{p} -> REQUEST -> P{i}")

        if ts[p] < ts[i] or (ts[p] == ts[i] and p < i):
            print(f"P{i} -> OK -> P{p}")
            replies += 1
        else:
            print(f"P{i} defers reply")

    if replies == n - 1:
        print(f"\nP{p} enters CS")
    else:
        print(f"\nP{p} waits for replies")

ricart()