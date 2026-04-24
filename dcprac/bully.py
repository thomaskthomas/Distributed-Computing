def bully_election():
    n = int(input("Enter number of processes: "))
    process = [1] * n

    crashed = int(input("Enter process ID that crashed: "))
    process[crashed] = 0
    print(f"Process {crashed} has crashed")

    initiator = int(input("Enter process ID that starts election: "))
    print(f"\nElection started by process {initiator}")

    coordinator = initiator

    for i in range(initiator + 1, n):
        if process[i] == 1:
            print(f"Election message sent from {initiator} to {i}")
            print(f"OK message from {i}")
            print(f"New election started by process {i}")
            coordinator = i

    print(f"\nFinal Coordinator is Process {coordinator}")

    for i in range(n):
        if process[i] == 1 and i != coordinator:
            print(f"Message to {i}: Coordinator is {coordinator}")

bully_election()