def load_balance():
    n = int(input("Enter number of nodes: "))
    p = int(input("Enter number of processes: "))

    load = [0] * n

    for i in range(p):
        min_node = load.index(min(load))
        load[min_node] += 1
        print(f"Process {i + 1} assigned to Node {min_node}")

    print("\nFinal Load Distribution:")
    for i in range(n):
        print(f"Node {i} has {load[i]} processes")

load_balance()