from math import sin, pi

def rk4(f, x0, y0, x1, n):
    vx = [0] * (n + 1)
    vy = [0] * (n + 1)
    vy2 = [0] * (n + 1)
    h = (x1 - x0) / float(n)
    vx[0] = x0
    vy[0] = y0
    vy2[0] = 0
    k21 = 0
    k22 = 0
    k23 = 0
    for i in range(0, n):
        vx[i+1] = vx[i] + h

        k11 = f(vy[i], 					 vy2[i])
        k21 = f2(vy[i], 					vy2[i])

        k12 = f(vy[i] + 0.5*h*k11, vy2[i] + 0.5*h*k21)
        k22 = f2(vy[i] + 0.5*h*k11, vy2[i] + 0.5*h*k21)

        k13 = f(vy[i] + 0.5*h*k12, vy2[i] + 0.5*h*k22)
        k23 = f2(vy[i] + 0.5*h*k12, vy2[i] + 0.5*h*k22)

        k14 = f(vy[i] + h*k13, 			 vy2[i] + h*k23)
        k24 = f2(vy[i] + h*k13, 			vy2[i] + h*k23)

        vy[i+1] = vy[i] + h*(k11 + 2*k12 + 2*k13 + k14) / 6
        vy2[i+1] = vy2[i] + h*(k21 + 2*k22 + 2*k23 + k24) / 6

    return vx, vy, vy2

def f(x, y):	#d2y/dt2 = dw/dt
    return y

def f2(x, y): #dy/dt = w
		return -(0.16/0.5)*y - (9.81/1.2)*sin(x)

vx, vy, vy2 = rk4(f, 0, pi/2, 18, 72)

fo = open("problem2Python.txt", "a+")
for item in vy:
    fo.write("%s " % float(item)) #Expected X
fo.write("\n")
for item in vy2:
    fo.write("%s " % float(item)) #Expected Y
fo.close()

for i in range(0, len(vx)):
	print vx[i], '\t\t', vy[i], '\t\t', vy2[i]
