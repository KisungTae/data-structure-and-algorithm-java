package com.company.hard;

//and is debating which ones to accept. She needs a 15-minute break between appointments and
//        therefore she cannot accept any adjacent requests. Given a sequence of back-to-back appointment
//        requests (all multiples of 15 minutes, none overlap, and none can be moved), find the optimal
//        (highest total booked minutes) set the masseuse can honor. Return the number of minutes.
//        EXAMPLE
//        Input: {30, 15, 60, 75, 45, 15, 15, 45}
//        Output180 minutes ({30, 60, 45, 45}).

// 2:42

public class Question16Review {
    public Question16Review() {
        int[] arr = {30, 15, 60, 75, 45, 15, 15, 45};
//        int[] arr = {30, 15, 60, 75, 45, 15};

        Integer max = Integer.MIN_VALUE;
        int[] max_sum = new int[1];
        sum(arr, 0, 0, max_sum);
        System.out.println("max: " + max_sum[0]);
    }

    private void sum(int[] arr, int curr_index, int curr_sum, int[] max_sum) {
        if (curr_index >= arr.length) {
            max_sum[0] = Math.max(curr_sum, max_sum[0]);
            return;
        }

        for (int i = curr_index; i < curr_index + 2; i++) {
            if (i >= arr.length) {
                max_sum[0] = Math.max(curr_sum, max_sum[0]);
                return;
            }
            sum(arr, i + 2, curr_sum + arr[i], max_sum);
        }
    }


}
