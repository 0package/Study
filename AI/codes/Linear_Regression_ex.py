# 선형회귀-경사하강법 알고리즘
import numpy as np
import matplotlib.pyplot as plt

X = np.array([0.0, 1.0, 2.0])
y = np.array([3.0,3.5,5.5])

w = 0 #기울기
b = 0 #절편

lr=0.01 #학습률
epochs = 1000 # 반복 횟수

n = float(len(X))

#경사하강법 ### 알고리즘 이해! P.289
for i in range(epochs):
    y_pred = w*X + b
    dw = (2/n) * sum(X*(y_pred-y))    #미분한 것
    db = (2/n) * sum(y_pred-y)
    w = w - lr*dw
    b = b - lr*db

#기울기와 절편 출력
print(w,b)

#예측값 생성
y_pred = w*X + b

#입력 데이터를 그래프 상에 찍기
plt.scatter(X,y)

plt.plot([min(X), max(X)], [min(y_pred),max(y_pred)], color='red')