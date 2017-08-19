
public class UnionFind
{
    private int[] id;
    private int count;
    private int[] sz;        //only for weighted_quick_union
    public UnionFind(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
        	id[i] = i;
        sz = new int[N];    //only for weighted_quick_union
        for (int i = 0; i < N; i++)
        	sz[i] = 1;         //only for weighted_quick_union
    }
    public boolean connected(int p, int q)
    {
        return qf_find(q) == qf_find(q);
    }
    public int count()
    {    
    	return count;    
    }
    public void qf_union(int p, int q)
    {   //quick find algorithm
        int pID = qf_find(p);
        int qID = qf_find(q);
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }
    public int qf_find(int p)
    {
        return id[p];
    }
    
    public void qu_union(int p, int q)
    {   //quick union algorithm
        int qRoot = qu_find(q);
        int pRoot = qu_find(p);
        if (qRoot == pRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
    public int qu_find(int p){
        while (p != id[p]) p = id[p];
    	return p;
    }

    public void weighted_quick_union(int p, int q)
    {
        int i = wqu_find(q);
        int j = wqu_find(p);
        if (sz[i] > sz[j]){
        	id[j] = i;
        	sz[i] += sz[j];
        }
        else{
        	id[i] = j;
        	sz[j] += sz[i];
        }
        count--;
    }
    public int wqu_find(int p)
    {
    	while(p != id[p]) p = id[p];
    	return p;
    }
}
