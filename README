DBSCAN (Density-Based Spatial Clustering of Applications with Noise) is a data clustering algorithm that finds a number of clusters starting from the estimated density distribution of corresponding nodes.
DBSCAN is one of the most common clustering algorithms and also most cited in scientific literature.
DBSCAN requires two parameters: e (eps)-threshold distance and the minimum number of points required to form a cluster (minPts).
It starts with an arbitrary starting point that has not been visited. This point's e-neighborhood is retrieved,
and if it contains sufficiently many points, a cluster is started. Otherwise, the point is labeled as noise. 
Note that this point might later be found in a sufficiently sized e-environment of a different point and hence be made part of a cluster.

If a point is found to be part of a cluster, its e-neighborhood is also part of that cluster. Hence, all points that are
found within the e-neighborhood are added, as is their own e-neighborhood. This process continues until the cluster is completely found.
Then, a new unvisited point is retrieved and processed, leading to the discovery of a further cluster or noise.

PSEUDOCODE
-------------------------------------

DBSCAN(D, eps, MinPts)
   C = 0
   for each unvisited point P in dataset D
      mark P as visited
      N = getNeighbors (P, eps)
      if sizeof(N) < MinPts
         mark P as NOISE
      else
         C = next cluster
         expandCluster(P, N, C, eps, MinPts)
          
expandCluster(P, N, C, eps, MinPts)
   add P to cluster C
   for each point P' in N 
      if P' is not visited
         mark P' as visited
         N' = getNeighbors(P', eps)
         if sizeof(N') >= MinPts
            N = N joined with N'
      if P' is not yet member of any cluster
         add P' to cluster C
		 
---------------------------------------

