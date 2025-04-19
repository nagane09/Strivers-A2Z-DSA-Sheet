/*There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is the start time
of meeting i and F[i] is the finish time of meeting i. The task is to find the maximum number of meetings that can be
accommodated in the meeting room. You can accommodate a meeting if the start time of the meeting is strictly greater than
the finish time of the previous meeting. Print all meeting numbers.

Note: If two meetings can be chosen for the same slot then choose meeting that finishes earlier.

Example 1:

Input:
N = 6
S = {1,3,0,5,8,5}
F = {2,4,6,7,9,9} 
Output:
{1,2,4,5}
Explanation:
We can attend the 1st meeting from (1 to 2), then the 2nd meeting from (3 to 4), then the 4th meeting from (5 to 7),
and the last meeting we can attend is the 5th from (8 to 9). It can be shown that this is the maximum number of meetings
we can attend.*/

class Solution {

    static class Meeting {
        int start, end, index;
        Meeting(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        ArrayList<Meeting> meet = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            meet.add(new Meeting(S[i], F[i], i + 1));
        }

        // Sort by end time. If same, sort by index
        meet.sort((m1, m2) -> {
            if (m1.end != m2.end) {
                return m1.end - m2.end;
            } else {
                return m1.index - m2.index;
            }
        });

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).index); // Always select the first meeting
        int lastEnd = meet.get(0).end;

        for (int i = 1; i < N; i++) {
            if (meet.get(i).start > lastEnd) {
                ans.add(meet.get(i).index);
                lastEnd = meet.get(i).end;
            }
        }

        Collections.sort(ans); // optional
        return ans;
    }
}

