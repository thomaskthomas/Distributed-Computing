def distributed_global_average():
    n = int(input("Enter number of nodes: "))

    print("Enter values:")
    values = [float(input()) for _ in range(n)]

    rounds = int(input("Enter number of rounds: "))

    for round_ in range(1, rounds + 1):
        new_values = [
            (values[i] + values[(i - 1) % n] + values[(i + 1) % n]) / 3
            for i in range(n)
        ]
        values = new_values

        print(f"Round {round_}: " + " ".join(f"{v:.2f}" for v in values))

distributed_global_average()