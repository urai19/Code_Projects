function [graph, lowHighDist]= map(alt,water)
    [row,col]=size(alt);
    highest=-10000;
    lowest=10000;
    for x=1:row
        for y=1:col
            if(water(x,y)==0 && alt(x,y)<lowest)
                lowest=alt(x,y);
            end
            if(water(x,y)==0&&alt(x,y)>highest)
                highest=alt(x,y);
            end
        end
    end
    
    graph= zeros(row,col,3,'uint8');
    for i=1:row
        for j=1:col
            if alt(i,j)<0
                graph(i,j,1)=0;
                graph(i,j,2)=0;
                graph(i,j,3)=0;
            elseif alt(i,j)>=0 && alt(i,j)<=1000
                graph(i,j,1)=0;
                graph(i,j,2)=255;
                graph(i,j,3)=0;
            elseif alt(i,j)>=1001 && alt(i,j)<=2000
                graph(i,j,1)=255;
                graph(i,j,2)=255;
                graph(i,j,3)=0;
            elseif alt(i,j)>=2001 && alt(i,j)<=3000
                graph(i,j,1)=255;
                graph(i,j,2)=128;
                graph(i,j,3)=0;
            elseif alt(i,j)>=3001 && alt(i,j)<=4000
                graph(i,j,1)=255;
                graph(i,j,2)=0;
                graph(i,j,3)=0;
            elseif alt(i,j)>4000
                graph(i,j,1)=255;
                graph(i,j,2)=255;
                graph(i,j,3)=255;
            end
            if alt(i,j)==highest
                graph(i,j,1)=255;
                graph(i,j,2)=0;
                graph(i,j,3)=255;
            end
            if alt(i,j)==lowest
                graph(i,j,1)=128;
                graph(i,j,2)=0;
                graph(i,j,3)=255;
            end
            if water(i,j)==1
                graph(i,j,1)=0;
                graph(i,j,2)=0;
                graph(i,j,3)=255;
            end
        end
    end
    [maxR,maxC]= find(alt==highest);
    [minR,minC]=find(alt==lowest & water==0);
    
    r1=maxR(1);
    r2=minR(1);
    c1=maxC(1);
    c2=minC(1);
    
    a=r2-r1;
    b=c2-c1;
    lowHighDist=sqrt(a^2+b^2)*10000;
end
    
    