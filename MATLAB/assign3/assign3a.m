% question 1
for a=0:5
    M = eye(6);
    M(1:7:end)=0;
    M(1,2)=1;
    M(2,1)=1;
    M(3,3)=1;
    M(4,5)=1;
    M(5,4)=1;
    M(6,6)=1;
    M(2,3)=2;
    M(3,2)=2;
    M(5,6)=6;
    M(5,6)=1;
    M(1,3)=a;
    M(3,1)=-a;
    M(3,6)=a;
    M(6,3)=-a;

    subplot(2,1,1)
    plot(a,real(eig(M)),'o');
    hold on
    xlabel('a');
    title('real part')

    subplot(2,1,2)
    plot(a,imag(eig(M)),'o')
    hold on
    xlabel('a');
    title('imaginary part')

end

